

<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'employee.label', default: 'Employee')}" />
        <title><g:message code="default.create.label" args="[entityName]" /></title>
    </head>
    <body>
    <div id="content" role="main">
        <div class="container">
            <section class="row">
                <a href="#create-employee" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
                <div class="nav" role="navigation">
                    <ul>
                        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                        <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
                    </ul>
                </div>
            </section>
            <section class="row">
                <div id="create-employee" class="col-12 content scaffold-create" role="main">
                    <h1><g:message code="default.create.label" args="[entityName]" /></h1>
                    <g:if test="${flash.message}">
                    <div class="message" role="status">${flash.message}</div>
                    </g:if>
                    <g:hasErrors bean="${this.employee}">
                    <ul class="errors" role="alert">
                        <g:eachError bean="${this.employee}" var="error">
                        <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
                        </g:eachError>
                    </ul>
                    </g:hasErrors>

                    <%-- <g:form resource="${this.employee}" method="POST">
                        <fieldset class="form">
                            <f:all bean="employee"/>            
                        </fieldset>
                        <fieldset class="buttons">
                            <g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" />
                        </fieldset>
                    </g:form> --%>
        <g:form  controller="employee" resource="${this.employee}" method="post" enctype="multipart/form-data">
        
        <label for="firstName">First Name:</label>
        <g:textField name="firstName" required="true" />

        <label for="lastName">Last Name:</label>
        <g:textField name="lastName" required="true" />

        <label for="designation">Designation:</label>
        <g:textField name="designation" required="true" />

        <label for="gender">Gender:</label>
        <g:select name="gender" from="${['Male', 'Female']}" required="true" />

        <label for="nationality">Nationality:</label>
        <g:textField name="nationality" required="true" />

        <label for="phoneNumber">Phone Number:</label>
        <g:textField name="phoneNumber" required="true" />

        <label for="address">Address:</label>
        <g:textField name="address" required="true" />

        <label for="email">Email:</label>
        <g:textField name="email" required="true" />

        <label for="team">Team:</label>
        <g:select name="team" from="${teamList}" optionKey="id" optionValue="name" required="true" /> 

        <label for="isTeamlead">Is Team Lead:</label>
        <g:checkBox name="isTeamlead" />

        <label for="teamLead">Team Lead:</label>
        <g:select name="teamLead" from="${teamleadList}" optionKey="id" optionValue="firstName" required="true" />

        <label for="teamLead">Department:</label>
        <g:select name="department" from="${departmentList}" optionKey="id" optionValue="name" required="true" />

        <label for="imageName">Image:</label>
        <input type="file" name="imageName" />

    <fieldset class="buttons">
        <g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" />
    </fieldset>

    </g:form >
                </div>
            </section>
        </div>
    </div>
    </body>
</html>
