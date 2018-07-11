package xml;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

import java.util.Arrays;

public class MyAdvice {

    /**
     * before通知：前置通知，目标方法执行前，一定会执行
     */
    public void before(JoinPoint joinPoint){
        System.out.println("调用方法开始了，获取参数："+ Arrays.toString(joinPoint.getArgs()));
    }

    /**
     * after通知：后置通知，目标方法执行之后，一定会执行
     */
    public void after(JoinPoint joinPoint) throws Throwable {
        System.out.println("调用方法结束了，方法名称："+ joinPoint.getSignature());

    }

    public void afterThrowing(JoinPoint joinPoint,Exception e) throws Throwable {
        System.out.println("目标方法发生异常，异常信息："+e.getStackTrace());
    }

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
    public Object around(ProceedingJoinPoint joinPjoint) throws Throwable {
        System.out.println("环绕通知1");
        //调用目标方法之前替换参数
        Object[] args = joinPjoint.getArgs();
        args[0]="Android";
        Object proceed = joinPjoint.proceed(args);
        System.out.println("环绕通知2");
        return proceed;
    }
}
