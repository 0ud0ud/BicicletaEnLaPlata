package aspectJ;

import java.util.Date;

public aspect loggingConsole {
	Date date = new Date();
	
	public pointcut metodosDeLosDAOS() : execution(* misDaos..*(..));
	
	before(): metodosDeLosDAOS() {
		System.out.println(
				date.toString() + 
				" Se va ejectuar el metodo: " + thisJoinPoint.getSignature() +
				" que se encontra: " + thisJoinPoint.getSourceLocation() + 
				" target:" + thisJoinPoint.getTarget() +
				" con los argumentos: "	+ thisJoinPoint.getArgs() +"\n");
	}
	
	after(): metodosDeLosDAOS() {
		System.out.println(	date.toString() + " Se finalizo el metodo: " + thisJoinPoint.getSignature() +"\n");
	}
}

