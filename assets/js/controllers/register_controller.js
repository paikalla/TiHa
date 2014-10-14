TodoApp.controller('RegisterController', ['$scope', function($scope){

  $scope.new_user = {
    username: '',
    password: '',
    password_again: ''
  };

  $scope.errors = [];

  $scope.register = function(){
    $.post('/rekisteroidy', { username: $scope.new_user.username, password: $scope.new_user.password, password_again: $scope.new_user.password_again })
    .done(function(res){
      res = angular.fromJson(res);

      $scope.errors = res.errors;
      $scope.$apply();
    });
  }

}]);
