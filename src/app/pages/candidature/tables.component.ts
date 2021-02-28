import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-tables',
  templateUrl: './tables.component.html',
  styleUrls: ['./tables.component.scss']
})
export class TablesComponent implements OnInit {

  candidatures:Offre[];
  role;

  constructor() { }

  ngOnInit() {
    this.role = "PRO"

    this.candidatures =[
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
          salaire: 24456,
          etat: "en attente"
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
          salaire: 24456,
          etat: "en attente"
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
          salaire: 24456,
          etat: "en attente"
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
          salaire: 24456,
          etat: "en attente"
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
          salaire: 24456,
          etat: "en attente"
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
          salaire: 24456,
          etat: "en attente"
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
          salaire: 24456,
          etat: "en attente"
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
          salaire: 24456,
          etat: "en attente"
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
          salaire: 24456,
          etat: "en attente"
        }
      ]
  }

  accepter(index)
  {
    this.candidatures[index].etat = "Accpetée";
  }

  refuser(index)
  {
    this.candidatures[index].etat = "Refusée";
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
  salaire,
  etat
}
