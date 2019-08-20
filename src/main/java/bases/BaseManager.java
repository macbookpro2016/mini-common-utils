package bases;

import my.MySpringContext;
import org.springframework.beans.factory.annotation.Value;
import utils.CheckUtils;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/**
 * @description:
 * @author: fengzhihang
 * @create: 2019-07-30 14:50
 **/
public class BaseManager<T> {

    @Value("${basemanager.modelpackagename}")
    String modelPackageName;

    @Value("${basemanager.examplepackagename}")
    String examplePackageName;

    private static final String MAPPER_BEAN_PREFIX = "Mapper";
    private static String MODEL_PACKAGENAME = "model";
    private static final String MAPPER_QUERY_METHOD_NAME = "selectByExample";
    private static final String GET_METHOD_PREFIX = "get";
    private static final String EXAMPLE_BEAN_NAME_SUFFIX = "Example";
    private static final String GET_CRITERIA_BEAN_NAME = "createCriteria";
    private static final String CRITERIA_CONDITION_PREFIX = "and";
    private static final String CRITERIA_CONDITION_SUFFIX = "EqualTo";
    private static String EXAMPLE_PACKAGENAME = "com.mini.stockprovider.model.";
    private static final String SERIALVERSIONUID = "serialVersionUID";

    private MySpringContext mySpringContext;

    public BaseManager(MySpringContext mySpringContext){
        this.mySpringContext = mySpringContext;
    }


    public List<T> getModelByEqualsCondition(T condition) {
        if(!CheckUtils.isEmpty(modelPackageName)){
            MODEL_PACKAGENAME = modelPackageName;
        }
        if(!CheckUtils.isEmpty(examplePackageName)){
            EXAMPLE_PACKAGENAME = examplePackageName;
        }
        Class clazz = condition.getClass();
        String packageName = clazz.getPackage().getName();
        // 检查是否model类
        if(!MODEL_PACKAGENAME.equals(packageName)){
            return null;
        }
        List<T> result = null;
        String className = clazz.getSimpleName();
        String mapperBeanName = className.substring(0, 1).toLowerCase() + className.substring(1, className.length()) + MAPPER_BEAN_PREFIX;
        String exampleBeanName = EXAMPLE_PACKAGENAME + className + EXAMPLE_BEAN_NAME_SUFFIX;
        Object example = null;
        try {
            example = Class.forName(exampleBeanName).newInstance();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
            return null;
        }catch (IllegalAccessException e){
            e.printStackTrace();
            return null;
        }catch (InstantiationException e){
            e.printStackTrace();
            return null;
        }

        Object mapper = mySpringContext.getBean(mapperBeanName);
        Method createCriteria;
        Object criteria;
        try {
            createCriteria = example.getClass().getMethod(GET_CRITERIA_BEAN_NAME);
            criteria = createCriteria.invoke(example);
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields){
                String fieldName = field.getName();
                if(SERIALVERSIONUID.equals(fieldName)){
                    continue;
                }
                fieldName = fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1, fieldName.length());
                String getMethodName = GET_METHOD_PREFIX + fieldName;
                Method getValueMethod = clazz.getMethod(getMethodName);
                Object value = getValueMethod.invoke(condition);
                if(null != value) {
                    Method andMethod = criteria.getClass().getMethod(CRITERIA_CONDITION_PREFIX + fieldName + CRITERIA_CONDITION_SUFFIX, value.getClass());
                    andMethod.invoke(criteria, value);
                }
            }
            Method queryMethod = mapper.getClass().getMethod(MAPPER_QUERY_METHOD_NAME, example.getClass());
            result = (List) queryMethod.invoke(mapper, example);
        }catch (NoSuchMethodException e){
            e.printStackTrace();
            return null;
        }catch (InvocationTargetException e){
            e.printStackTrace();
            return null;
        }catch (IllegalAccessException e){
            e.printStackTrace();
            return null;
        }
        return  result;
    }

}