export class BugsStatisticModel {
  allBugsCount: number;
  activeBugs: number;
  inActiveBugs: number;

  static fromJson(json: any): BugsStatisticModel {
    const model = new BugsStatisticModel();

    model.allBugsCount = json.allBugsCount;
    model.activeBugs = json.activeBugs;
    model.inActiveBugs = json.inActiveBugs;


    return model;
  }
}
