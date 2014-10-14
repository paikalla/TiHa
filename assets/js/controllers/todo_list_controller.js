TodoApp.controller('TodoListController', ['$scope', '$http', '$location', function($scope, $http, $location){

  if(!$scope.$parent.user){
    $location.path('/kirjaudu');
  }

  $http({
    method: 'GET',
    url: '/askareet'
  }).success(function(todos){
    $scope.todos = todos;
  });

  $scope.remove = function(todo, index){
    if(confirm('Oletko varma, että haluat poistaa askareen?')){
      $.post('/askareet/' + todo.id + '/poista')
      .done(function(){
        $scope.todos.splice(index, 1);
        $scope.$apply();
      });
    }
  }

}]);
