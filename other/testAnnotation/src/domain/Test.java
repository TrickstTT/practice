package domain;

import annotation.FiledAnnotation;
import annotation.TestAnnotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Field;

@TestAnnotation(id = 4, name="Gunslinger")
public class Test {
    public static void main(String[] args) throws ClassNotFoundException {

    }

    public static void testFiledAnnotation(){
        BeTested beTested = new BeTested();
        Class clazz = beTested.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if(field.isAnnotationPresent(FiledAnnotation.class)){
                FiledAnnotation fieldAnnotation = field.getAnnotation(FiledAnnotation.class);
                System.out.println(fieldAnnotation.name());
            }
        }
    }

    public static void testTest(){
        boolean hasAnnotation = Test.class.isAnnotationPresent(TestAnnotation.class);
        if(hasAnnotation){
            TestAnnotation testAnnotation = Test.class.getAnnotation(TestAnnotation.class);
            Annotation[] annotations = Test.class.getAnnotations();
            if(annotations != null){
                for (Annotation annotation : annotations) {
                    System.out.println("annotationSimpleName = " + annotation.annotationType().getSimpleName());
                    System.out.println("annotationName = " + annotation.annotationType().getName());
                    System.out.println("annotationType = " + annotation.annotationType());
                }
            }
            if(testAnnotation != null){
                System.out.println("id="+testAnnotation.id());
                System.out.println("name="+ testAnnotation.name());
            }
        }
    }
}
