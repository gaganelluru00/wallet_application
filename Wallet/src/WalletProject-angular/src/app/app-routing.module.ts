import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CreateAccountComponent } from './create-account/create-account.component';
import { DepositComponent } from './deposit/deposit.component';
import { WithdrawComponent } from './withdraw/withdraw.component';
import { FundTransferComponent } from './fund-transfer/fund-transfer.component';
import { ShowBalanceComponent } from './show-balance/show-balance.component';
import { PrintTransactionsComponent } from './print-transactions/print-transactions.component';
import { ShowDetailsComponent } from './show-details/show-details.component';
import { LoginComponent } from './login/login.component';
import { OperationMenuComponent } from './operation-menu/operation-menu.component';
import { HomeComponent } from './home/home.component';
import { AppComponent } from './app.component';
import { DeleteAccountComponent } from './delete-account/delete-account.component';
import { UpdateDetailsComponent } from './update-details/update-details.component';


const routes: Routes = [{path:'transfer/add',component:CreateAccountComponent},
{path:'transfer/deposit',component:DepositComponent},{path:'transfer/withdraw',component:WithdrawComponent},
{path:'transfer/fund',component:FundTransferComponent},{path:'transfer/show',component:ShowBalanceComponent},
{path:'transfer/print',component:PrintTransactionsComponent},{path:'transfer/details',component:ShowDetailsComponent},
{path:'transfer/login',component:LoginComponent},{path:'transfer/menu',component:OperationMenuComponent},{path:'transfer/home',component:HomeComponent},
{path:'transfer/app',component:AppComponent},{path:'transfer/delete',component:DeleteAccountComponent},{path:'transfer/update',component:UpdateDetailsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
