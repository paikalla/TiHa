var TodoApp = angular.module('TodoApp', ['ngRoute']);

TodoApp.config(['$routeProvider', function($routeProvider){
	$routeProvider
	.when('/askareet', {
		templateUrl: 'assets/js/views/todo_list.html',
		controller: 'TodoListController'
	})
  .when('/askareet/uusi', {
    templateUrl: 'assets/js/views/create_todo.html',
    controller: 'CreateTodoController'
  })
  .when('/askareet/:todoId', {
    templateUrl: 'assets/js/views/edit_todo.html',
    controller: 'EditTodoController'
  })
  .when('/luokat', {
    templateUrl: 'assets/js/views/category_list.html',
    controller: 'CategoryListController'
  })
  .when('/luokat/uusi', {
    templateUrl: 'assets/js/views/create_category.html',
    controller: 'CreateCategoryController'
  })
  .when('/luokat/:categoryId', {
    templateUrl: 'assets/js/views/edit_category.html',
    controller: 'EditCategoryController'
  })
	.when('/luokat/:categoryId/askareet', {
		templateUrl: 'assets/js/views/category_todo_list.html',
		controller: 'CategoryTodoListController'
	})
  .when('/kirjaudu', {
    templateUrl: 'assets/js/views/login.html',
    controller: 'LoginController'
  })
  .when('/rekisteroidy', {
    templateUrl: 'assets/js/views/register.html',
    controller: 'RegisterController'
  })
	.otherwise({
		redirectTo: '/askareet'
	});
}]);
