package annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect //定义切面
@Component
public class MyAdvice {

    //配置切入点
    //使用一个返回值为void 方法体为空的方法来命名切入点
    @Pointcut("execution(* annotation.BookService.addBook(..))")
    public void myPointCut(){}

    /**
     * before通知：前置通知，目标方法执行前，一定会执行
     */
    @Before("myPointCut()")
    public void before(JoinPoint joinPoint){
        System.out.println("可以进行初始化操作"+ joinPoint.getSignature().getName());
    }

    /**
     * after通知：后置通知，目标方法执行之后，一定会执行
     */
    @After("myPointCut()")
    public void after(JoinPoint joinPoint) throws Throwable {
        System.out.println("释放资源");

    }

    @AfterThrowing(value = "myPointCut()",throwing = "e")
    public void afterThrowing(JoinPoint joinPoint,Exception e) throws Throwable {
        System.out.println("目标方法发生异常，异常信息："+e.getStackTrace());
    }

    @AfterReturning("myPointCut()")
    public void afterReturning(JoinPoint joinPoint) throws Throwable {
        System.out.println("返回通知");
    }

    /**
     * 1. 返回值必须是Object
     * 2. 必须接受一个参数，类型ProceedingJoinPoint参数
     * 3. 抛出异常Throwable
     *
     * 需要手动指定目标方法执行
     */
    @Around(value = "myPointCut()")
    public Object around(ProceedingJoinPoint joinPjoint) throws Throwable {
        System.out.println("开启事务");
        //调用目标方法之前替换参数
        Object[] args = joinPjoint.getArgs();
        args[0]="Android";
        Object proceed = joinPjoint.proceed(args);
        System.out.println("提交事务");
        return proceed;
    }
}
