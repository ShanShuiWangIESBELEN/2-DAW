import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {TopVarComponent} from "./components/top-var/top-var.component";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, TopVarComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {}
