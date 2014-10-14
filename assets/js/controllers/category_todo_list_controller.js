TodoApp.controller('CategoryTodoListController', ['$scope', '$http', '$routeParams', function($scope, $http, $routeParams){

  $http({
    method: 'GET',
    url: '/luokat/' + $routeParams.categoryId
  })
  .success(function(category){
    $scope.category = category;
  });

  $http({
    method: 'GET',
    url: 'luokat/' + $routeParams.categoryId + '/askareet'
  })
  .success(function(todos){
    $scope.todos = todos;
  });

}]);
