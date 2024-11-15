import { Routes } from '@angular/router';
import {HomeComponentComponent} from "./components/home-component/home-component.component";
import {ListarComponent} from "./components/empresa/listar/listar.component";
import {DetallesComponent} from "./components/empresa/detalles/detalles.component";
import {CrearComponent} from "./components/empresa/crear/crear.component";
import {EditarComponent} from "./components/empresa/editar/editar.component";

export const routes: Routes = [
  {
    path: '',
    component: HomeComponentComponent,
    title: 'Empresas Malagueñas'
  },
  {
    path: 'empresa',
    component: ListarComponent,
    title: 'Empresas Malagueñas'
  },
  {
    path:'empresa/detalle/:id',
    component: DetallesComponent,
    title: 'Empresas Malagueñas'
  },
  {
    path:'empresa/crear',
    component: CrearComponent,
    title: 'Empresas Malagueñas'
  },
  {
    path:'empresa/editar/:id',
    component: EditarComponent,
    title: 'Empresas Malagueñas'
  },
];
