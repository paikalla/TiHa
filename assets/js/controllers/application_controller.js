TodoApp.controller('ApplicationController', ['$scope', '$http', '$location', function($scope, $http, $location){

  $http({
    method: 'GET',
    url: '/kirjautunut_kayttaja'
  })
  .success(function(res){
    res = angular.fromJson(res);

    if(res.logged_user){
      $scope.user = res.logged_user;
    }else{
      $location.path('/kirjaudu');
    }
  });

  $scope.logout = function(){
    $.post('/kirjaudu_ulos')
    .done(function(){
      $location.path('/kirjaudu');

      $scope.user = null;
      $scope.$apply();
    });
  }

}]);
