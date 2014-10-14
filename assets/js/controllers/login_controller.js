TodoApp.controller('LoginController', ['$scope', '$location', function($scope, $location){

  if($scope.user){
    $location.path('/askareet');
  }

  $scope.errors = [];
  $scope.username = '';
  $scope.password = '';
  $scope.password_again = '';

  $scope.login = function(){
    $.post('/kirjaudu', { username: $scope.username, password: $scope.password })
    .done(function(res){
      res = angular.fromJson(res);

      if(res.authenticated){
        $scope.$parent.user = res.authenticated;

        $location.path('/askareet');
      }else{
        $scope.errors = ['Väärä käyttäjätunnus tai salasana!'];
      }

      $scope.$apply();
    });
  }

}]);
