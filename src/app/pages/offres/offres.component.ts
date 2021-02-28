import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-offres',
  templateUrl: './offres.component.html',
  styleUrls: ['./offres.component.css']
})
export class OffresComponent implements OnInit {
  offres : Offre[];
  constructor() { }

  ngOnInit(): void {
    this.offres = [
      {
        id : 1,
        titre : "Software engineer",
        entreprise: "facebook",
        description: `ljfgbljsnfmorflmkqznrfmklmoqzirhmoqrfnm oihqzroknfmqgfoq noqi oiqhfmoqf mqjfmofmoqsfmjqsfouqè<dmljfbmlb
                      qmkfnd!mn mo zqhmfoznfmo moiqginsf lsbjfwkj bskj mjsbmfjbsmfb mjsbmfjlbsmdjfs mljbsdfmlnm knsmwlfnmswknf`,
        duree: 34,
        date_debut: "23/4/2020",
        date_fin: "23/4/2020",
        ville : "casablanca",
        mode: "distance",
        salaire: 24456
      },
      {
        id : 1,
        titre : "Software engineer",
        entreprise: "facebook",
        description: `ljfgbljsnfmorflmkqznrfmklmoqzirhmoqrfnm oihqzroknfmqgfoq noqi oiqhfmoqf mqjfmofmoqsfmjqsfouqè<dmljfbmlb
                      qmkfnd!mn mo zqhmfoznfmo moiqginsf lsbjfwkj bskj mjsbmfjbsmfb mjsbmfjlbsmdjfs mljbsdfmlnm knsmwlfnmswknf`,
        duree: 34,
        date_debut: "23/4/2020",
        date_fin: "23/4/2020",
        ville : "casablanca",
        mode: "distance",
        salaire: 24456
      },
      {
        id : 1,
        titre : "Software engineer",
        entreprise: "facebook",
        description: `ljfgbljsnfmorflmkqznrfmklmoqzirhmoqrfnm oihqzroknfmqgfoq noqi oiqhfmoqf mqjfmofmoqsfmjqsfouqè<dmljfbmlb
                        qmkfnd!mn mo zqhmfoznfmo moiqginsf lsbjfwkj bskj mjsbmfjbsmfb mjsbmfjlbsmdjfs mljbsdfmlnm knsmwlfnmswknf`,
        duree: 34,
        date_debut: "23/4/2020",
        date_fin: "23/4/2020",
        ville : "casablanca",
        mode: "distance",
        salaire: 24456
      },
      {
        id : 1,
        titre : "Software engineer",
        entreprise: "facebook",
        description: `ljfgbljsnfmorflmkqznrfmklmoqzirhmoqrfnm oihqzroknfmqgfoq noqi oiqhfmoqf mqjfmofmoqsfmjqsfouqè<dmljfbmlb
                      qmkfnd!mn mo zqhmfoznfmo moiqginsf lsbjfwkj bskj mjsbmfjbsmfb mjsbmfjlbsmdjfs mljbsdfmlnm knsmwlfnmswknf`,
        duree: 34,
        date_debut: "23/4/2020",
        date_fin: "23/4/2020",
        ville : "casablanca",
        mode: "distance",
        salaire: 24456
      },
      {
        id : 1,
        titre : "Software engineer",
        entreprise: "facebook",
        description: `ljfgbljsnfmorflmkqznrfmklmoqzirhmoqrfnm oihqzroknfmqgfoq noqi oiqhfmoqf mqjfmofmoqsfmjqsfouqè<dmljfbmlb
                      qmkfnd!mn mo zqhmfoznfmo moiqginsf lsbjfwkj bskj mjsbmfjbsmfb mjsbmfjlbsmdjfs mljbsdfmlnm knsmwlfnmswknf`,
        duree: 34,
        date_debut: "23/4/2020",
        date_fin: "23/4/2020",
        ville : "casablanca",
        mode: "distance",
        salaire: 24456
      },
      {
        id : 1,
        titre : "Software engineer",
        entreprise: "facebook",
        description: `ljfgbljsnfmorflmkqznrfmklmoqzirhmoqrfnm oihqzroknfmqgfoq noqi oiqhfmoqf mqjfmofmoqsfmjqsfouqè<dmljfbmlb
                      qmkfnd!mn mo zqhmfoznfmo moiqginsf lsbjfwkj bskj mjsbmfjbsmfb mjsbmfjlbsmdjfs mljbsdfmlnm knsmwlfnmswknf`,
        duree: 34,
        date_debut: "23/4/2020",
        date_fin: "23/4/2020",
        ville : "casablanca",
        mode: "distance",
        salaire: 24456
      },
      {
        id : 1,
        titre : "Software engineer",
        entreprise: "facebook",
        description: `ljfgbljsnfmorflmkqznrfmklmoqzirhmoqrfnm oihqzroknfmqgfoq noqi oiqhfmoqf mqjfmofmoqsfmjqsfouqè<dmljfbmlb
                      qmkfnd!mn mo zqhmfoznfmo moiqginsf lsbjfwkj bskj mjsbmfjbsmfb mjsbmfjlbsmdjfs mljbsdfmlnm knsmwlfnmswknf`,
        duree: 34,
        date_debut: "23/4/2020",
        date_fin: "23/4/2020",
        ville : "casablanca",
        mode: "distance",
        salaire: 24456
      },
      {
        id : 1,
        titre : "Software engineer",
        entreprise: "facebook",
        description: `ljfgbljsnfmorflmkqznrfmklmoqzirhmoqrfnm oihqzroknfmqgfoq noqi oiqhfmoqf mqjfmofmoqsfmjqsfouqè<dmljfbmlb
                      qmkfnd!mn mo zqhmfoznfmo moiqginsf lsbjfwkj bskj mjsbmfjbsmfb mjsbmfjlbsmdjfs mljbsdfmlnm knsmwlfnmswknf`,
        duree: 34,
        date_debut: "23/4/2020",
        date_fin: "23/4/2020",
        ville : "casablanca",
        mode: "distance",
        salaire: 24456
      },
      {
        id : 1,
        titre : "Software engineer",
        entreprise: "facebook",
        description: `ljfgbljsnfmorflmkqznrfmklmoqzirhmoqrfnm oihqzroknfmqgfoq noqi oiqhfmoqf mqjfmofmoqsfmjqsfouqè<dmljfbmlb
                    qmkfnd!mn mo zqhmfoznfmo moiqginsf lsbjfwkj bskj mjsbmfjbsmfb mjsbmfjlbsmdjfs mljbsdfmlnm knsmwlfnmswknf`,
        duree: 34,
        date_debut: "23/4/2020",
        date_fin: "23/4/2020",
        ville : "casablanca",
        mode: "distance",
        salaire: 24456
      }
    ]
  }

}

interface Offre{
  id,
  titre,
  entreprise,
  description,
  duree,
  date_debut,
  date_fin,
  ville,
  mode,
  salaire
}
