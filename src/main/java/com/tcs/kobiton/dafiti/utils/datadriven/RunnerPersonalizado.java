package com.tcs.kobiton.dafiti.utils.datadriven;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.logging.Logger;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.model.InitializationError;

/**
 * Personalizaci�n del Runner con el cual se puede determinar que busque y
 * modifique los .feature antes de ser ejecutados
 * 
 * @since 27/11/2017
 */
public class RunnerPersonalizado extends Runner {
	/**
	 * private Class<Cucumber> classValue; private Cucumber cucumber;
	 */

	private Class<CucumberWithSerenity> classValue;
	private CucumberWithSerenity cucumberWithSerenity;
	private String messageError = "Error con el Runner Personalizado";

	public RunnerPersonalizado(Class<CucumberWithSerenity> classValue)  {
		try {
			this.classValue = classValue;
			cucumberWithSerenity = new CucumberWithSerenity(classValue);
		} catch (InitializationError | IOException e) {
			Logger.getLogger("").info(messageError);
		}
	}

	@Override
	public Description getDescription() {
		return cucumberWithSerenity.getDescription();
	}

	private void runAnnotatedMethods(Class<?> annotation)  {
		try {
		if (!annotation.isAnnotation()) {
			return;
		}
		Method[] methods = this.classValue.getMethods();
		for (Method method : methods) {
			Annotation[] annotations = method.getAnnotations();
			for (Annotation item : annotations) {
				if (item.annotationType().equals(annotation)) {
					method.invoke(null);
					break;
				}
			}
		}
		}catch(Exception e) {
			Logger.getLogger("").info(messageError);
		}
	}

	@Override
	public void run(RunNotifier notifier) {
		try {
			runAnnotatedMethods(BeforeSuite.class);
			cucumberWithSerenity = new CucumberWithSerenity(classValue);
		} catch (Exception e) {
			Logger.getLogger("").info(messageError);
		}
		cucumberWithSerenity.run(notifier);
	}
}
