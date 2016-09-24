app = angular.module("app", []);
app.controller("MainCtrl", ["$http" ,function($http){	
	var self = this;
	self.todos = [];

	$http.get('http://localhost:8080/restapp1/rest/hello/todos').
        success(function(data) {
            self.todos  = data;
        })
        .error(function(error){
        	alert("erro" + err);
        });


}]);