import {Component} from "@angular/core";
import {HelloDuetPage} from "./pages/helloDuet/helloDuet.component";

export const routes = [
  { path: "", component: HelloDuetPage}
];

export const navigatableComponents = [
  HelloDuetPage
];

@Component({
  selector: "main",
  template: "<page-router-outlet></page-router-outlet>"
})

export class AppComponent{}
