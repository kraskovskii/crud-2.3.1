package web.config;

import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

public class AppInit extends AbstractAnnotationConfigDispatcherServletInitializer {
    //AbstractAnnotationConfigDispatcherServletInitializer
    //позволяет выполнить привязку сервлета к URL и указать классы конфигурации — корневой и для MVC.

    // Метод, указывающий на класс конфигурации
    // Указываем фреймворку Spring, что использовать в качестве корневого
    // (root) контекста: ApplicationContext — «корневая» конфигурация
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }


    // Добавление конфигурации, в которой инициализируем ViewResolver, для корректного отображения jsp.
    // Указываем фреймворку Spring, что использовать в качестве
    // контекста DispatcherServlet: WebApplicationContext — MVC
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{
                web.config.WebConfig.class
        };
    }


    /* Данный метод указывает url, на котором будет базироваться приложение
     Отображение DispatcherServlet, данный метод отвечает за шаблон URL*/
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }


    //фильтр для POST запросов
    @Override
    public void onStartup(ServletContext aServletContext) throws ServletException {
        super.onStartup(aServletContext);
        registerHiddenFieldFilter(aServletContext);
    }

    private void registerHiddenFieldFilter(ServletContext aContext) {
        aContext.addFilter("hiddenHttpMethodFilter",
                new HiddenHttpMethodFilter()).addMappingForUrlPatterns(null ,true, "/*");
    }
}