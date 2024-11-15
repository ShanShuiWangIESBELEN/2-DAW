import {Component, OnInit} from '@angular/core';
import {Empresa} from "../../../../models/empresa";
import {EmpresaService} from "../../../../service/empresa.service";
import {RouterLink} from "@angular/router";
import {FormsModule} from "@angular/forms";
import {NgForOf, NgIf} from "@angular/common";

@Component({
  selector: 'app-listar',
  standalone: true,
  imports: [
    RouterLink,
    FormsModule,
    NgForOf,
    NgIf
  ],
  templateUrl: './listar.component.html',
  styleUrl: './listar.component.css'
})
export class ListarComponent implements OnInit{
  empresas: Empresa[] = [];
  empresasFiltradas: Empresa[] = [];
  filtro: string = '';

  constructor(public empresaService: EmpresaService) {}

  ngOnInit(): void {
    this.empresaService.getAll().subscribe((data: Empresa[])=>{
      this.empresas = data;
      this.empresasFiltradas = this.empresas;
    })

  }

  deleteEmpresa(id: any){
    this.empresaService.delete(id).subscribe(res => {
      this.empresasFiltradas = this.empresas.filter(emp => emp.id !== id);
    })
  }

  filtrarEmpresasPorNombre(): void {
    if (this.filtro === '') {
      this.empresasFiltradas = this.empresas;
    } else {
      this.empresasFiltradas = this.empresas.filter(empresa => {
        return empresa.nombre.toLowerCase().includes(this.filtro.toLowerCase());
      });
    }
  }
  copiarAlPortapapeles(textoACopiar: string) {
    navigator.clipboard.writeText(textoACopiar).then(() => {
      alert('Texto copiado al portapapeles: ' + textoACopiar);
    }).catch((err) => {
      console.error('Error al copiar al portapapeles: ', err);
    });
  }
}
