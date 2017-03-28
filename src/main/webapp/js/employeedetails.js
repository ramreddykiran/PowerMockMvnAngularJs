 //http://localhost:8080/PowerMockMvnAngularJs/employees-details.html
  var app = angular.module("employeeApp",[]);
  app.controller("empController",function($scope,$location,$http){
  var baseUrl = $location.absUrl().substr(0,$location.absUrl().lastIndexOf("/")) + "/resources/employee";
	  //$scope.empname = "employee2";
	  $scope.getEmployees = function() {
		 /* $scope.employees=[{"empId":"11111","empName":"emp1","addresses":[{"pinCode":"900022","country":"India"},{"pinCode":"911122","country":"US"}]},
		                    {"empId":"22222","empName":"emp2","addresses":[{"pinCode":"900022","country":"India"},{"pinCode":"911122","country":"US"}]}];*/
		  $http({
			  headers: {
			        "Content-Type": "application/json"
			    },
			url:baseUrl+"/get-employees?emp-name=" + $scope.empname,
		  	method:"GET"
		  }).then(function success(response){
			  $scope.employees=response.data;
			  $scope.statusMessage=response.statusText;
			  console.log("employees "+$scope.employees);
		  },function error(response){
			  $scope.statusMessage=response.statusText;
		  });
	  };
  });
