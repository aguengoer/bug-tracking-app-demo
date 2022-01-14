import {Component, Input, OnInit} from '@angular/core';
import {NgbActiveModal, NgbDateStruct} from '@ng-bootstrap/ng-bootstrap';
import {BugTrackingResponseModel} from '../bug-tracking-response.model';
import {DateTimeUtil} from '../../date-time.util';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {BugCreateUpdateService} from "./bug-create-update.service";


@Component({
  selector: 'app-person-edit-form',
  templateUrl: './bug-edit-form.component.html',
  styleUrls: ['./bug-edit-form.component.css']
})
export class BugEditFormComponent implements OnInit {

  @Input() bugTrackingModel: BugTrackingResponseModel;
  recordingDateModel: NgbDateStruct;
  public bugTrackForm: FormGroup;
  date: { year: number, month: number };


  constructor(private activeModal: NgbActiveModal, private bugApiService: BugCreateUpdateService, private formBuilder: FormBuilder) {
    this.bugTrackForm = this.buildBugTrackingFormGroup();
  }

  ngOnInit(): void {
    if (this.bugTrackingModel) {
      this.recordingDateModel = DateTimeUtil.stringToNgbDateStruct(this.bugTrackingModel.recordingDate);
    } else {
      this.bugTrackingModel = new BugTrackingResponseModel();
    }
  }

  public closeModal(): void {
    this.activeModal.close('success');
  }

  public getStatus(): boolean {
    return this.bugTrackingModel.status;
  }

  public submit(): void {
    this.bugTrackingModel.recordingDate = DateTimeUtil.ngbDateStructToString(this.recordingDateModel, true);

    if (this.bugTrackForm.valid) {
      if (this.bugTrackingModel.userId) {
        this.bugApiService.doUpdate(this.bugTrackingModel.userId, this.bugTrackingModel).subscribe((personModel: any) => {
        });
      } else {
        this.bugApiService.doCreate(this.bugTrackingModel).subscribe((personModel: any) => {
        });
      }
      this.activeModal.close('success');
    }
  }

  private buildBugTrackingFormGroup() {
    return this.formBuilder.group({
      firstName: [, Validators.required],
      lastName: [, Validators.required],
      email: [, Validators.required],
      recordingDate: [, Validators.required],
      description: [, Validators.required],
      status: [, Validators.required],
    });
  }
}
