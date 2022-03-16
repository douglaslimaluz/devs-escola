import { DatailPokemonComponent } from './components/datail-pokemon/datail-pokemon.component';
import { ListPokemonsComponent } from './components/list-pokemons/list-pokemons.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {path:'pokemons', component: ListPokemonsComponent},
  {path:'pokemon/:name', component: DatailPokemonComponent},
  {path:'', redirectTo: '/pokemons', pathMatch: 'full'},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
