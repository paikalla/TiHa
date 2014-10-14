TodoApp.controller('CreateCategoryController', ['$scope', '$location', function($scope, $location){

  if(!$scope.$parent.user){
    $location.path('/kirjaudu');
  }

  $scope.new_category = {
    name: ''
  };

  $scope.errors = [];

  $scope.add_category = function(){
    $.post('/luokat', { name: $scope.new_category.name })
    .done(function(res){
      res = angular.fromJson(res);

      $scope.errors = res.errors;

      if(res.errors.length == 0){
        $location.path('/luokat');
      }

      $scope.$apply();
    });
  }

}]);
