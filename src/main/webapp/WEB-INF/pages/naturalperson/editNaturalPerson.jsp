<%-- 
    Document   : index
    Created on : Nov 24, 2023, 7:42:54 PM
    Author     : Brayan Esteves
--%>

<!DOCTYPE html>
<html>
    <jsp:include page="/WEB-INF/pages/commons/head.jsp" />

    <body>



        <form action="${pageContext.request.contextPath}/NaturalPersonController?action=update&reference=${naturalPerson.reference}" method="POST" class="was-validated">

            <jsp:include page="/WEB-INF/pages/commons/buttonNavigationEdit.jsp" />

            <section id="details">

                <div class="container">

                    <div class="row">
                        <div class="col">
                            <div class="card">
                                <div class="card-header">
                                    <h4>Edit</h4>
                                </div>
                                <div class="card-body">
                                    <div class="form-group">
                                        <label for="referenceNacionality">Nacionality</label>
                                        <select class="form-control" name="referenceNacionality" id="referenceNacionality">
                                            <option id="58">Venezuela</option>
                                            <option id="57">Colombia</option>
                                            <option id="56">Chile</option>
                                            <option id="54">Argentina</option>                            
                                            <option id="51">Perú</option>
                                            <option id="50">El Salvador</option>                            
                                        </select>
                                    </div>

                                    <div class="form-group">
                                        <label for="referenceCountry">Country</label>
                                        <select class="form-control" name="referenceCountry" id="referenceCountry">
                                            <option id="1">Any</option>                          
                                        </select>
                                    </div>

                                    <div class="form-group">
                                        <label for="identificationDocument">Identification Document</label>
                                        <input type="text" class="form-control" name="identificationDocument" id="identificationDocument" value="${naturalPerson.identificationDocument}" />
                                    </div>

                                    <div class="form-group">
                                        <label for="names">Names</label>
                                        <input type="text" class="form-control" name="names" id="names" value="${naturalPerson.names}" />
                                    </div>

                                    <div class="form-group">
                                        <label for="surnames">Surnames</label>
                                        <input type="text" class="form-control" name="surnames" id="surnames" value="${naturalPerson.surnames}" />
                                    </div>

                                    <div class="form-group">
                                        <label for="referentialPhoneNumber">Referential Phone Number</label>
                                        <input type="text" class="form-control" name="referentialPhoneNumber" id="referentialPhoneNumber" value="${naturalPerson.referentialPhoneNumber}" />
                                    </div>

                                    <div class="form-group">
                                        <label for="taxAddress">Tax Address</label>
                                        <textarea class="form-control" id="taxAddress" name="taxAddress" rows="3">${naturalPerson.taxAddress}</textarea>
                                    </div>
                                </div>
                            </div>
                        </div>                    
                    </div>

                </div>

            </section>

        </form>

        <jsp:include page="/WEB-INF/pages/commons/footer.jsp" />
        <jsp:include page="/WEB-INF/pages/commons/scripts.jsp" />

    </body>
</html>