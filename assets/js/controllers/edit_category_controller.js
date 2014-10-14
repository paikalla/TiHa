TodoApp.controller('EditCategoryController', ['$scope', '$routeParams', '$http', '$location', function($scope, $routeParams, $http, $location){

  $http({
    method: 'GET',
    url: '/luokat/' + $routeParams.categoryId
  })
  .success(function(category){
    $scope.category = category;
  });

  $scope.errors = [];

  $scope.edit_category = function(){
    $.post('/luokat/' + $routeParams.categoryId + '/muokkaa', { name: $scope.category.name })
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
