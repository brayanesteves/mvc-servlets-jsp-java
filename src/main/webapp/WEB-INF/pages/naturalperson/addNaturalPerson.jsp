<div class="modal fade" id="addNaturalPersonModal">
    
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            
            <div class="modal-header bg-info text-white">
                <h5 class="modal-title">Add - Natural Person</h5>
                <button class="close" data-dismiss="modal">
                    <span>&times;</span>
                </button>
            </div>
            
            <form action="${pageContext.request.contextPath}/NaturalPersonController?action=add" method="POST">
                <div class="modal-body">
                    
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
                        <input type="text" class="form-control" name="identificationDocument" id="identificationDocument" />
                    </div>
                    
                    <div class="form-group">
                        <label for="names">Names</label>
                        <input type="text" class="form-control" name="names" id="names" />
                    </div>
                    
                    <div class="form-group">
                        <label for="surnames">Surnames</label>
                        <input type="text" class="form-control" name="surnames" id="surnames" />
                    </div>
                    
                    <div class="form-group">
                        <label for="referentialPhoneNumber">Referential Phone Number</label>
                        <input type="text" class="form-control" name="referentialPhoneNumber" id="referentialPhoneNumber" />
                    </div>
                    
                    <div class="form-group">
                        <label for="taxAddress">Tax Address</label>
                        <textarea class="form-control" id="taxAddress" name="taxAddress" rows="3"></textarea>
                    </div>
                    
                </div>
                
                <div class="modal-footer">
                    <button type="submit" class="btn btn-primary">Save</button>
                </div>
            </form>
            
        </div>
    </div>
    
</div>