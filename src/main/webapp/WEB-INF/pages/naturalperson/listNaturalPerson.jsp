<%@taglib prefix="naturalperson" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="es_VE" />

<section id="natural-persons">
    <div class="container">
        
        <div class="row">
            
            <div class="col-md-9">
                
                <div class="card">
                    <div class="card-header">
                        <h4>List - Natural persons</h4>
                    </div>
                </div>
                
                <table class="table table-striped">
                    <thead class="thead-dark">
                        <tr>
                            <th>#</th>
                            <th>Nacionality</th>
                            <th>Country</th>
                            <th>Identification Document</th>
                            <th>Names</th>
                            <th>Surnames</th>
                            <th>Referential Phone Number</th>
                            <th>Tax Address</th>
                            <th>Activate</th>
                            <th>Removed</th>
                            <th>Locked</th>
                            <th>Date Admission</th>
                            <th>Locked</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    
                    <tbody>
                        <naturalperson:forEach var="naturalPersons" items="${naturalpersons}">
                            <tr>
                                <td></td>
                                <td>${naturalPersons.referenceNacionality}</td>
                                <td>${naturalPersons.referenceCountry}</td>
                                <td>${naturalPersons.identificationDocument}</td>
                                <td>${naturalPersons.names}</td>
                                <td>${naturalPersons.surnames}</td>
                                <td>${naturalPersons.referentialPhoneNumber}</td>
                                <td>${naturalPersons.taxAddress}</td>
                                <td>${naturalPersons.condition}</td>
                                <td>${naturalPersons.removed}</td>
                                <td>${naturalPersons.locked}</td>
                                <td>${naturalPersons.dateAdmission}</td>
                                <td>${naturalPersons.checkTime}</td>
                                <td>
                                    <a href="${pageContext.request.contextPath}/NaturalPersonController?action=edit&reference=${naturalPersons.reference}" class="btn btn-secondary">
                                        <i class="fas fa-angle-double-right"></i> Edit
                                    </a>
                                </td>
                            </tr>
                        </naturalperson:forEach>
                    </tbody>
                    
                </table>
                
            </div>
            
            <div class="col-md-3">
            
                <div class="card text-center bg-danger text-white mb-3">
                    <div class="card-body">
                        <h3 class="">Natural Person Removed</h3>
                        <h4 class="display-4">${naturalPersonsRemoved}</h4>
                    </div>
                </div>
                    
                <div class="card text-center bg-success text-white mb-3">
                    <div class="card-body">
                        <h3 class="">Natural Person Total Add</h3>
                        <h4 class="display-4"><i class="fas fa-users"></i> ${naturalPersonsTotal}</h4>
                    </div>
                </div>
                
            </div>
            
        </div>
        
    </div>    
</section>
                    
<jsp:include page="/WEB-INF/pages/naturalperson/addNaturalPerson.jsp" />