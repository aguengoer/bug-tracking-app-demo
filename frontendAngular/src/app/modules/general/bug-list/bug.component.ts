import {Component, OnInit} from '@angular/core';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {BugEditFormComponent} from './bug-edit-form/bug-edit-form.component';
import {BugTrackingApiService} from './bug-tracking-api.service';
import {BugTrackingResponseModel} from './bug-tracking-response.model';
import {Router} from '@angular/router';

@Component({
  selector: 'app-about',
  templateUrl: './bug.component.html',
  styleUrls: ['./bug.component.css']
})
export class BugComponent implements OnInit {

  public bugTrackingModel: BugTrackingResponseModel[];
  public isLoading: boolean;

  constructor(private modalService: NgbModal, private personApiService: BugTrackingApiService, private router: Router) {
    this.isLoading = false;
    this.bugTrackingModel = [];
  }

  ngOnInit(): void {
    this.load();
  }

  public load() {
    this.isLoading = true;
    this.personApiService.doGetAll().subscribe((personModel: any) => {
      this.bugTrackingModel = personModel;
      this.isLoading = false;
    });
  }

  openEditForm(personModel: BugTrackingResponseModel) {
    const modalRef = this.modalService.open(BugEditFormComponent, {scrollable: true, backdrop: 'static'});
    modalRef.componentInstance.bugTrackingModel = personModel;
    modalRef.result.then(() => this.reload());
  }

  openEditNewForm() {
    const modalRef = this.modalService.open(BugEditFormComponent, {scrollable: true, backdrop: 'static'});
    modalRef.result.then(() => this.reload());
  }

  deleteUser(item: BugTrackingResponseModel) {
    this.personApiService.doDelete(item.userId).subscribe((personModel) => {
    });
    this.reload();
  }

  public displayStatus(item: BugTrackingResponseModel): string {
    return item.status === true ? 'Active' : 'Inactive';
  }

  private reload(): void {
    window.location.reload();
  }

  public popoverContent(item: BugTrackingResponseModel): string {
    return `Do you want to delete bug \"${item.firstName}\"?
            <br/>
            <b><span class='text-danger text-monospace mr-1'>Attention!</span></b>
            This step can <b>not</b> be reversed.`;
  }

}
