TodoApp.controller('CreateTodoController', ['$scope', '$http', '$location', function($scope, $http, $location){

  if(!$scope.$parent.user){
    $location.path('/kirjaudu');
  }

  $http({
    method: 'GET',
    url: '/luokat'
  }).success(function(categories){
    $scope.categories = categories;
  });

  $scope.errors = [];

  $scope.new_todo = {
    description: '',
    priority: null,
    category: null,
  }

  $scope.add_todo = function(){
    $.post('/askareet', { description: $scope.new_todo.description, priority: $scope.new_todo.priority, category: $scope.new_todo.category, user: $scope.$parent.user })
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
