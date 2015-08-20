/**
 * Created by oliver on 21/08/15.
 */

/*global angular */
angular.module('app', ['ui.router', 'girlApp'])

    .config(function($urlRouterProvider, $stateProvider){
        'use strict';

        $urlRouterProvider.otherwise("/girl");

        $stateProvider
            .state('girl', {
                url: '/girl',
                templateUrl: 'girl/girl.html'
            });
    });