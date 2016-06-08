import {Component} from "@angular/core";
import {RouteConfig} from "@angular/router-deprecated";
import {NS_ROUTER_DIRECTIVES, NS_ROUTER_PROVIDERS} from "nativescript-angular/router";

import {HelloDuetPage} from "./pages/helloDuet/helloDuet.component";

@Component({
  selector: "main",
  directives: [NS_ROUTER_DIRECTIVES],
  providers: [NS_ROUTER_PROVIDERS],
  template: "<page-router-outlet></page-router-outlet>"
})
@RouteConfig([
  {path: "/HelloDuet", component: HelloDuetPage, name: "Hello Duet", useAsDefault: true}
])

export class AppComponent{}
