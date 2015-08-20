/**
 * Created by oliver on 21/08/15.
 */

/*global angular */
angular.module('app', ['ui.router', 'girlApp'])

    .config(function($urlRouterProvider, $stateProvider){
        'use strict';

        $urlRouterProvider.otherwise("/home");

        $stateProvider
            .state('girl', {
                url: '/choose_a_girl',
                templateUrl: 'girl/girl.html'
            });
    });