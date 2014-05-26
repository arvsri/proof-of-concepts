package com.anucana.web.views;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.context.NoSuchMessageException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;


public class ErrorHandlingJsonView extends MappingJacksonJsonView {
	
	private static Map<String,String> resolvedErrorMessages = new HashMap<String, String>();
	
	protected Object filterModel(Map<String, Object> model) {
		Map<String, Object> result = new HashMap<String, Object>(model.size());
		for (Map.Entry<String, Object> entry : model.entrySet()) {
			if (entry.getValue() instanceof BindingResult){
				BindingResult errors = (BindingResult)entry.getValue();
				SimpleViewError viewError = new SimpleViewError();
				if(errors.hasErrors()) {
					for(FieldError fieldError : errors.getFieldErrors()){
						viewError.add(new SimpleViewFieldError(fieldError.getField(), getResolvedErrorMessage(fieldError)));
					}
				}
				if(viewError.hasFieldErrors()){
					result.put("viewError", viewError);
				}
			}else{
				result.put(entry.getKey(), entry.getValue());
			}
		}
		return result;
	}
	
	private String getResolvedErrorMessage(FieldError fieldError){
		for(String errorCode : fieldError.getCodes()){
			if(resolvedErrorMessages.get(errorCode) != null){
				return resolvedErrorMessages.get(errorCode);
			}
			
			String errorMessage = null;
			try{
				errorMessage = getWebApplicationContext().getMessage(errorCode, fieldError.getArguments(),Locale.US);
			}catch(NoSuchMessageException ex){
				continue;
			}
			
			if(errorMessage != null && errorMessage.trim().length() != 0){
				resolvedErrorMessages.put(errorCode, errorMessage);
				return errorMessage;
			}
		}
		
		return "Error Message Not found";	
	}
	
	public static class SimpleViewError{
		
		List<SimpleViewFieldError> fieldErrors = new ArrayList<SimpleViewFieldError>();
		
		public SimpleViewError add(SimpleViewFieldError fieldError ){
			fieldErrors.add(fieldError);
			return this;
		}

		public boolean hasFieldErrors(){
			return !fieldErrors.isEmpty();
		}

		public List<SimpleViewFieldError> getFieldErrors() {
			return fieldErrors;
		}
		
	}

	public static class SimpleViewFieldError{

		private String field;
		private String errorMessage;
		
		public SimpleViewFieldError(String field,String errorMessage){
			this.field = field;
			this.errorMessage = errorMessage;
		}

		public String getField() {
			return field;
		}

		public String getErrorMessage() {
			return errorMessage;
		}
		
	}
	
}

