package com.my.blog.springboot.thymeleaf.controller;

import com.my.blog.springboot.thymeleaf.util.MethodTest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by 13 on 2017/9/14.
 */
@Controller
public class MethodTestController {

    @RequestMapping("/test1")
    public String test1(HttpServletRequest request) {
        return "test";
    }

    /*

    由于并没有将MethodTest实例放入request域中,因此会导致异常的产生,spring表达式语句异常及调用对象不存在的异常:
    org.thymeleaf.exceptions.TemplateProcessingException: Exception evaluating SpringEL expression: "MethodTest.service()"
    Caused by: org.springframework.expression.spel.SpelEvaluationException: EL1011E: Method call: Attempted to call method test() on null context object

    具体报错如下:

    org.thymeleaf.exceptions.TemplateProcessingException: Exception evaluating SpringEL expression: "MethodTest.test()" (test:8)
    at org.thymeleaf.spring4.expression.SpelVariableExpressionEvaluator.evaluate(SpelVariableExpressionEvaluator.java:161) ~[thymeleaf-spring4-2.1.5.RELEASE.jar:2.1.5.RELEASE]
    at org.thymeleaf.standard.expression.VariableExpression.executeVariable(VariableExpression.java:154) ~[thymeleaf-2.1.5.RELEASE.jar:2.1.5.RELEASE]
    at org.thymeleaf.standard.expression.SimpleExpression.executeSimple(SimpleExpression.java:59) ~[thymeleaf-2.1.5.RELEASE.jar:2.1.5.RELEASE]
    at org.thymeleaf.standard.expression.Expression.execute(Expression.java:103) ~[thymeleaf-2.1.5.RELEASE.jar:2.1.5.RELEASE]
    at org.thymeleaf.standard.expression.Expression.execute(Expression.java:133) ~[thymeleaf-2.1.5.RELEASE.jar:2.1.5.RELEASE]
    at org.thymeleaf.standard.expression.Expression.execute(Expression.java:120) ~[thymeleaf-2.1.5.RELEASE.jar:2.1.5.RELEASE]
    at org.thymeleaf.standard.processor.attr.AbstractStandardTextChildModifierAttrProcessor.getText(AbstractStandardTextChildModifierAttrProcessor.java:68) ~[thymeleaf-2.1.5.RELEASE.jar:2.1.5.RELEASE]
    at org.thymeleaf.processor.attr.AbstractTextChildModifierAttrProcessor.getModifiedChildren(AbstractTextChildModifierAttrProcessor.java:59) ~[thymeleaf-2.1.5.RELEASE.jar:2.1.5.RELEASE]
    at org.thymeleaf.processor.attr.AbstractChildrenModifierAttrProcessor.processAttribute(AbstractChildrenModifierAttrProcessor.java:59) ~[thymeleaf-2.1.5.RELEASE.jar:2.1.5.RELEASE]
    at org.thymeleaf.processor.attr.AbstractAttrProcessor.doProcess(AbstractAttrProcessor.java:87) ~[thymeleaf-2.1.5.RELEASE.jar:2.1.5.RELEASE]
    at org.thymeleaf.processor.AbstractProcessor.process(AbstractProcessor.java:212) ~[thymeleaf-2.1.5.RELEASE.jar:2.1.5.RELEASE]
    at org.thymeleaf.dom.Node.applyNextProcessor(Node.java:1017) ~[thymeleaf-2.1.5.RELEASE.jar:2.1.5.RELEASE]
    at org.thymeleaf.dom.Node.processNode(Node.java:972) ~[thymeleaf-2.1.5.RELEASE.jar:2.1.5.RELEASE]
    at org.thymeleaf.dom.NestableNode.computeNextChild(NestableNode.java:695) ~[thymeleaf-2.1.5.RELEASE.jar:2.1.5.RELEASE]
    at org.thymeleaf.dom.NestableNode.doAdditionalProcess(NestableNode.java:668) ~[thymeleaf-2.1.5.RELEASE.jar:2.1.5.RELEASE]
    at org.thymeleaf.dom.Node.processNode(Node.java:990) ~[thymeleaf-2.1.5.RELEASE.jar:2.1.5.RELEASE]
    at org.thymeleaf.dom.NestableNode.computeNextChild(NestableNode.java:695) ~[thymeleaf-2.1.5.RELEASE.jar:2.1.5.RELEASE]
    at org.thymeleaf.dom.NestableNode.doAdditionalProcess(NestableNode.java:668) ~[thymeleaf-2.1.5.RELEASE.jar:2.1.5.RELEASE]
    at org.thymeleaf.dom.Node.processNode(Node.java:990) ~[thymeleaf-2.1.5.RELEASE.jar:2.1.5.RELEASE]
    at org.thymeleaf.dom.NestableNode.computeNextChild(NestableNode.java:695) ~[thymeleaf-2.1.5.RELEASE.jar:2.1.5.RELEASE]
    at org.thymeleaf.dom.NestableNode.doAdditionalProcess(NestableNode.java:668) ~[thymeleaf-2.1.5.RELEASE.jar:2.1.5.RELEASE]
    at org.thymeleaf.dom.Node.processNode(Node.java:990) ~[thymeleaf-2.1.5.RELEASE.jar:2.1.5.RELEASE]
    at org.thymeleaf.dom.Document.process(Document.java:93) ~[thymeleaf-2.1.5.RELEASE.jar:2.1.5.RELEASE]
    at org.thymeleaf.TemplateEngine.process(TemplateEngine.java:1155) ~[thymeleaf-2.1.5.RELEASE.jar:2.1.5.RELEASE]
    at org.thymeleaf.TemplateEngine.process(TemplateEngine.java:1060) ~[thymeleaf-2.1.5.RELEASE.jar:2.1.5.RELEASE]
    at org.thymeleaf.TemplateEngine.process(TemplateEngine.java:1011) ~[thymeleaf-2.1.5.RELEASE.jar:2.1.5.RELEASE]
    at org.thymeleaf.spring4.view.ThymeleafView.renderFragment(ThymeleafView.java:335) ~[thymeleaf-spring4-2.1.5.RELEASE.jar:2.1.5.RELEASE]
    at org.thymeleaf.spring4.view.ThymeleafView.render(ThymeleafView.java:190) ~[thymeleaf-spring4-2.1.5.RELEASE.jar:2.1.5.RELEASE]
    at org.springframework.web.servlet.DispatcherServlet.render(DispatcherServlet.java:1271) ~[spring-webmvc-4.3.6.RELEASE.jar:4.3.6.RELEASE]
    at org.springframework.web.servlet.DispatcherServlet.processDispatchResult(DispatcherServlet.java:1037) ~[spring-webmvc-4.3.6.RELEASE.jar:4.3.6.RELEASE]
    at org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:980) ~[spring-webmvc-4.3.6.RELEASE.jar:4.3.6.RELEASE]
    at org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:897) ~[spring-webmvc-4.3.6.RELEASE.jar:4.3.6.RELEASE]
    at org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:970) ~[spring-webmvc-4.3.6.RELEASE.jar:4.3.6.RELEASE]
    at org.springframework.web.servlet.FrameworkServlet.doGet(FrameworkServlet.java:861) ~[spring-webmvc-4.3.6.RELEASE.jar:4.3.6.RELEASE]
    at javax.servlet.http.HttpServlet.service(HttpServlet.java:622) ~[tomcat-embed-core-8.5.11.jar:8.5.11]
    at org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:846) ~[spring-webmvc-4.3.6.RELEASE.jar:4.3.6.RELEASE]
    at javax.servlet.http.HttpServlet.service(HttpServlet.java:729) ~[tomcat-embed-core-8.5.11.jar:8.5.11]
    at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:230) [tomcat-embed-core-8.5.11.jar:8.5.11]
    at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:165) [tomcat-embed-core-8.5.11.jar:8.5.11]
    at org.apache.tomcat.websocket.server.WsFilter.doFilter(WsFilter.java:52) ~[tomcat-embed-websocket-8.5.11.jar:8.5.11]
    at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:192) [tomcat-embed-core-8.5.11.jar:8.5.11]
    at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:165) [tomcat-embed-core-8.5.11.jar:8.5.11]
    at org.springframework.web.filter.RequestContextFilter.doFilterInternal(RequestContextFilter.java:99) ~[spring-web-4.3.6.RELEASE.jar:4.3.6.RELEASE]
    at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:107) [spring-web-4.3.6.RELEASE.jar:4.3.6.RELEASE]
    at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:192) [tomcat-embed-core-8.5.11.jar:8.5.11]
    at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:165) [tomcat-embed-core-8.5.11.jar:8.5.11]
    at org.springframework.web.filter.HttpPutFormContentFilter.doFilterInternal(HttpPutFormContentFilter.java:105) ~[spring-web-4.3.6.RELEASE.jar:4.3.6.RELEASE]
    at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:107) [spring-web-4.3.6.RELEASE.jar:4.3.6.RELEASE]
    at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:192) [tomcat-embed-core-8.5.11.jar:8.5.11]
    at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:165) [tomcat-embed-core-8.5.11.jar:8.5.11]
    at org.springframework.web.filter.HiddenHttpMethodFilter.doFilterInternal(HiddenHttpMethodFilter.java:81) ~[spring-web-4.3.6.RELEASE.jar:4.3.6.RELEASE]
    at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:107) [spring-web-4.3.6.RELEASE.jar:4.3.6.RELEASE]
    at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:192) [tomcat-embed-core-8.5.11.jar:8.5.11]
    at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:165) [tomcat-embed-core-8.5.11.jar:8.5.11]
    at org.springframework.web.filter.CharacterEncodingFilter.doFilterInternal(CharacterEncodingFilter.java:197) ~[spring-web-4.3.6.RELEASE.jar:4.3.6.RELEASE]
    at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:107) [spring-web-4.3.6.RELEASE.jar:4.3.6.RELEASE]
    at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:192) [tomcat-embed-core-8.5.11.jar:8.5.11]
    at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:165) [tomcat-embed-core-8.5.11.jar:8.5.11]
    at org.springframework.boot.web.support.ErrorPageFilter.doFilter(ErrorPageFilter.java:115) [spring-boot-1.5.1.RELEASE.jar:1.5.1.RELEASE]
    at org.springframework.boot.web.support.ErrorPageFilter.access$000(ErrorPageFilter.java:59) [spring-boot-1.5.1.RELEASE.jar:1.5.1.RELEASE]
    at org.springframework.boot.web.support.ErrorPageFilter$1.doFilterInternal(ErrorPageFilter.java:90) [spring-boot-1.5.1.RELEASE.jar:1.5.1.RELEASE]
    at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:107) [spring-web-4.3.6.RELEASE.jar:4.3.6.RELEASE]
    at org.springframework.boot.web.support.ErrorPageFilter.doFilter(ErrorPageFilter.java:108) [spring-boot-1.5.1.RELEASE.jar:1.5.1.RELEASE]
    at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:192) [tomcat-embed-core-8.5.11.jar:8.5.11]
    at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:165) [tomcat-embed-core-8.5.11.jar:8.5.11]
    at org.apache.catalina.core.StandardWrapperValve.invoke(StandardWrapperValve.java:198) [tomcat-embed-core-8.5.11.jar:8.5.11]
    at org.apache.catalina.core.StandardContextValve.invoke(StandardContextValve.java:96) [tomcat-embed-core-8.5.11.jar:8.5.11]
    at org.apache.catalina.authenticator.AuthenticatorBase.invoke(AuthenticatorBase.java:474) [tomcat-embed-core-8.5.11.jar:8.5.11]
    at org.apache.catalina.core.StandardHostValve.invoke(StandardHostValve.java:140) [tomcat-embed-core-8.5.11.jar:8.5.11]
    at org.apache.catalina.valves.ErrorReportValve.invoke(ErrorReportValve.java:79) [tomcat-embed-core-8.5.11.jar:8.5.11]
    at org.apache.catalina.core.StandardEngineValve.invoke(StandardEngineValve.java:87) [tomcat-embed-core-8.5.11.jar:8.5.11]
    at org.apache.catalina.connector.CoyoteAdapter.service(CoyoteAdapter.java:349) [tomcat-embed-core-8.5.11.jar:8.5.11]
    at org.apache.coyote.http11.Http11Processor.service(Http11Processor.java:783) [tomcat-embed-core-8.5.11.jar:8.5.11]
    at org.apache.coyote.AbstractProcessorLight.process(AbstractProcessorLight.java:66) [tomcat-embed-core-8.5.11.jar:8.5.11]
    at org.apache.coyote.AbstractProtocol$ConnectionHandler.process(AbstractProtocol.java:798) [tomcat-embed-core-8.5.11.jar:8.5.11]
    at org.apache.tomcat.util.net.NioEndpoint$SocketProcessor.doRun(NioEndpoint.java:1434) [tomcat-embed-core-8.5.11.jar:8.5.11]
    at org.apache.tomcat.util.net.SocketProcessorBase.run(SocketProcessorBase.java:49) [tomcat-embed-core-8.5.11.jar:8.5.11]
    at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142) [na:1.8.0_121]
    at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617) [na:1.8.0_121]
    at org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:61) [tomcat-embed-core-8.5.11.jar:8.5.11]
    at java.lang.Thread.run(Thread.java:745) [na:1.8.0_121]
    Caused by: org.springframework.expression.spel.SpelEvaluationException: EL1011E: Method call: Attempted to call method test() on null context object
    at org.springframework.expression.spel.ast.MethodReference.throwIfNotNullSafe(MethodReference.java:144) ~[spring-expression-4.3.6.RELEASE.jar:4.3.6.RELEASE]
    at org.springframework.expression.spel.ast.MethodReference.getValueRef(MethodReference.java:73) ~[spring-expression-4.3.6.RELEASE.jar:4.3.6.RELEASE]
    at org.springframework.expression.spel.ast.CompoundExpression.getValueRef(CompoundExpression.java:66) ~[spring-expression-4.3.6.RELEASE.jar:4.3.6.RELEASE]
    at org.springframework.expression.spel.ast.CompoundExpression.getValueInternal(CompoundExpression.java:87) ~[spring-expression-4.3.6.RELEASE.jar:4.3.6.RELEASE]
    at org.springframework.expression.spel.ast.SpelNodeImpl.getValue(SpelNodeImpl.java:120) ~[spring-expression-4.3.6.RELEASE.jar:4.3.6.RELEASE]
    at org.springframework.expression.spel.standard.SpelExpression.getValue(SpelExpression.java:267) ~[spring-expression-4.3.6.RELEASE.jar:4.3.6.RELEASE]
    at org.thymeleaf.spring4.expression.SpelVariableExpressionEvaluator.evaluate(SpelVariableExpressionEvaluator.java:139) ~[thymeleaf-spring4-2.1.5.RELEASE.jar:2.1.5.RELEASE]
            ... 80 common frames omitted
    */

    @RequestMapping("/test2")
    public String test2(HttpServletRequest request) {
        request.setAttribute("MethodTest", new MethodTest());
        return "test";
    }

    @RequestMapping("/test3")
    public String test3(HttpServletRequest request) {
        request.setAttribute("MethodTest", new MethodTest());
        return "test3";
    }

}
