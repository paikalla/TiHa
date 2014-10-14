TodoApp.controller('EditTodoController', ['$scope', '$routeParams', '$http', '$location', function($scope, $routeParams, $http, $location){

  $http({
    method: 'GET',
    url: '/luokat'
  }).success(function(categories){
    $scope.categories = categories;
  });

  $http({
    method: 'GET',
    url: '/askareet/' + $routeParams.todoId
  })
  .success(function(todo){
    $scope.todo = todo;
  });

  $scope.errors = [];

  $scope.edit_todo = function(){
    $.post('/askareet/' + $routeParams.todoId + '/muokkaa', { description: $scope.todo.description, priority: $scope.todo.priority, category: $scope.todo.category })
    .done(function(res){
      res = angular.fromJson(res);

      $scope.errors = res.errors;

      if(res.errors.length == 0){
        $location.path('/askareet');
      }

      $scope.$apply();

    });
  }

}]);
