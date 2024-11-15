import {Component, OnInit} from '@angular/core';
import {Empresa} from "../../../models/empresa";
import {EmpresaService} from "../../../service/empresa.service";
import {NgForOf, NgIf, NgOptimizedImage} from "@angular/common";
import {RouterLink} from "@angular/router";
import {FormsModule} from "@angular/forms";
import L, {Map, Marker, marker, TileLayer} from "leaflet";


@Component({
  selector: 'app-home-component',
  standalone: true,
  imports: [
    NgOptimizedImage,
    NgForOf,
    RouterLink,
    FormsModule,
    NgIf
  ],
  templateUrl: './home-component.component.html',
  styleUrl: './home-component.component.css'
})
export class HomeComponentComponent implements OnInit{
  empresas: Empresa[] = [];

  constructor(public empresaService: EmpresaService) {}

  ngOnInit(): void {
    this.empresaService.getAll().subscribe(res => {
      this.empresas = res;
    })
  }

}
