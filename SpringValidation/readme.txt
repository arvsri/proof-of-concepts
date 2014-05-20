JSR 303 validation framwework and its support with spring
The main objectives are :
	- Service layer validation
	- Use of validation groups for using different groups of validation using the same bean
	- Error code resolutions using message resource bundle
	- JSON based error handling
 
Issues Found :
SpringValidatorAdapter doesn't support constraints message to be set as  message code ( using curly braces {} )


To further explore :
Group Chaining of Validation Constraints


URLs : 
1. http://localhost:8080/SpringValidation/?ops=create
2. http://localhost:8080/SpringValidation/user
