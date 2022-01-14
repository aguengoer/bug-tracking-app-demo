export class BugTrackingResponseModel {
  userId: string;
  firstName: string;
  lastName: string;
  email: string;
  recordingDate: string;
  description: string;
  status: boolean;

  static fromJson(json: any): BugTrackingResponseModel {
    const model = new BugTrackingResponseModel();

    model.userId = json.userId;
    model.firstName = json.firstName;
    model.lastName = json.lastName;
    model.email = json.email;
    model.recordingDate = json.recordingDate;
    model.description = json.description;
    model.status = json.status;

    return model;
  }
}
