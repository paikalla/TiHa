TodoApp.controller('CategoryListController', ['$scope', '$http', '$location', function($scope, $http, $location){

  if(!$scope.$parent.user){
    $location.path('/kirjaudu');
  }

  $http({
    method: 'GET',
    url: '/luokat'
  }).success(function(categories){
    $scope.categories = categories;
  });

  $scope.remove = function(category, index){
    if(confirm('Oletko varma, että haluat poistaa luokan?')){
      $.post('/luokat/' + category.id + '/poista')
      .done(function(){
        $scope.categories.splice(index, 1);
        $scope.$apply();
      });
    }
  }

}]);
