import {Component, inject, OnInit} from '@angular/core';
import { Observable} from "rxjs";
import {Empresa} from "../../../../models/empresa";
import {EmpresaService} from "../../../../service/empresa.service";
import {AsyncPipe, NgIf} from "@angular/common";
import {ActivatedRoute, RouterLink, Routes} from '@angular/router';
import {Map, marker, TileLayer} from "leaflet";
import * as L from 'leaflet';
import 'leaflet/dist/leaflet.css';

@Component({
  selector: 'app-detalles',
  standalone: true,
  imports: [
    AsyncPipe,
    RouterLink,
    NgIf
  ],
  template: `
    <article *ngIf="empresa | async as empresa" class="company-details">
      <section class="listing-description">
        <h2 class="listing-heading">{{empresa?.nombre}}</h2>
        <p class="listing-info">Número de teléfono: {{empresa?.telefono}}</p>
        <p class="listing-info">Dirección: {{empresa?.direccion}}</p>
        <p class="listing-info">{{empresa?.historia}}</p>
        <p class="listing-info">Email: {{empresa?.email}}</p>
      </section>
      <img class="listing-photo" [src]="empresa?.imagen" alt="Exterior photo of {{empresa?.nombre}}" />
      <div class="map-wrapper">
        <h2>Ubicación de {{empresa?.nombre}}</h2>
        <div id="map"></div>
      </div>
    </article>
  `,
  styleUrl: './detalles.component.css'
})
export class DetallesComponent {
  route: ActivatedRoute = inject(ActivatedRoute);
  empresaService = inject(EmpresaService);
  empresa: Observable<Empresa | undefined>;
  map: any;

  constructor() {
    const id = parseInt(this.route.snapshot.params['id'], 10);
    this.empresa = this.empresaService.find(id);
  }

  ngAfterViewInit() {
    setTimeout(() => {
      this.empresa.subscribe(em => {
        if (em) {
          const map = L.map('map').setView([em.latitud, em.longitud], 13);

          L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png').addTo(map);

          L.marker([em.latitud, em.longitud]).addTo(map)
            .bindPopup(em.nombre)
            .openPopup();
        }
      })
    }, 2000);


  }
}
