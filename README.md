# front end

## File Structure
Within the download you'll find the following directories and files:

```
argon-dashboard-angular
├── CHANGELOG.md
├── README.md
├── angular.json
├── e2e
├── package.json
├── src
│   ├── app
│   │   ├── app.component.html
│   │   ├── app.component.scss
│   │   ├── app.component.spec.ts
│   │   ├── app.component.ts
│   │   ├── app.module.ts
│   │   ├── app.routing.ts
│   │   ├── components
│   │   │   ├── components.module.spec.ts
│   │   │   ├── components.module.ts
│   │   │   ├── footer
│   │   │   │   ├── footer.component.html
│   │   │   │   ├── footer.component.scss
│   │   │   │   ├── footer.component.spec.ts
│   │   │   │   └── footer.component.ts
│   │   │   ├── navbar
│   │   │   │   ├── navbar.component.html
│   │   │   │   ├── navbar.component.scss
│   │   │   │   ├── navbar.component.spec.ts
│   │   │   │   └── navbar.component.ts
│   │   │   └── sidebar
│   │   │       ├── sidebar.component.html
│   │   │       ├── sidebar.component.scss
│   │   │       ├── sidebar.component.spec.ts
│   │   │       └── sidebar.component.ts
│   │   ├── layouts
│   │   │   ├── admin-layout
│   │   │   │   ├── admin-layout.component.html
│   │   │   │   ├── admin-layout.component.scss
│   │   │   │   ├── admin-layout.component.spec.ts
│   │   │   │   ├── admin-layout.component.ts
│   │   │   │   ├── admin-layout.module.ts
│   │   │   │   └── admin-layout.routing.ts
│   │   │   └── auth-layout
│   │   │       ├── auth-layout.component.html
│   │   │       ├── auth-layout.component.scss
│   │   │       ├── auth-layout.component.spec.ts
│   │   │       ├── auth-layout.component.ts
│   │   │       ├── auth-layout.module.ts
│   │   │       └── auth-layout.routing.ts
│   │   ├── pages
│   │   │   ├── dashboard
│   │   │   │   ├── dashboard.component.html
│   │   │   │   ├── dashboard.component.scss
│   │   │   │   ├── dashboard.component.spec.ts
│   │   │   │   └── dashboard.component.ts
│   │   │   ├── icons
│   │   │   │   ├── icons.component.html
│   │   │   │   ├── icons.component.scss
│   │   │   │   ├── icons.component.spec.ts
│   │   │   │   └── icons.component.ts
│   │   │   ├── login
│   │   │   │   ├── login.component.html
│   │   │   │   ├── login.component.scss
│   │   │   │   ├── login.component.spec.ts
│   │   │   │   └── login.component.ts
│   │   │   ├── maps
│   │   │   │   ├── maps.component.html
│   │   │   │   ├── maps.component.scss
│   │   │   │   ├── maps.component.spec.ts
│   │   │   │   └── maps.component.ts
│   │   │   ├── register
│   │   │   │   ├── register.component.html
│   │   │   │   ├── register.component.scss
│   │   │   │   ├── register.component.spec.ts
│   │   │   │   └── register.component.ts
│   │   │   ├── tables
│   │   │   │   ├── tables.component.html
│   │   │   │   ├── tables.component.scss
│   │   │   │   ├── tables.component.spec.ts
│   │   │   │   └── tables.component.ts
│   │   │   └── user-profile
│   │   │       ├── user-profile.component.html
│   │   │       ├── user-profile.component.scss
│   │   │       ├── user-profile.component.spec.ts
│   │   │       └── user-profile.component.ts
│   │   └── variables
│   │       └── charts.ts
│   ├── assets
│   │   ├── fonts
│   │   ├── img
│   │   ├── scss
│   │   │   ├── angular-differences
│   │   │   ├── argon.scss
│   │   │   ├── core
│   │   │   └── custom
│   │   └── vendor
│   ├── browserslist
│   ├── environments
│   ├── favicon.ico
│   ├── index.html
│   ├── main.ts
│   ├── polyfills.ts
│   ├── styles.scss
│   ├── test.ts
│   ├── tsconfig.app.json
│   ├── tsconfig.spec.json
│   └── tslint.json
├── tsconfig.json
└── tslint.json
```

## templates
* [argon-dashboard-angular](https://codeload.github.com/creativetimofficial/argon-dashboard-angular/zip/master)
* [paper-kit-2-angular-master](https://codeload.github.com/creativetimofficial/paper-kit-2-angular/zip/master)
* [blk-design-system-angular-master](https://codeload.github.com/creativetimofficial/blk-design-system-angular/zip/master)

### pages: 
* 1 - Accueil 
* 2 - Login
* 3 - Profil (Donneur + Association)
* 4 - Dons ( pour donneur et associations) soit les dons d'une publication ou tous les dons
* 5 - Publications (une regroupant toute les pubs et l'autre pour chaque association)  
      make sure you add a modal or popover for the list of donations and a button to donate directly to the assocation  
* 6 - Associations (une seule Page regroupant les associations ) 

### Taches
*   Hamza       :   Registration, login, Guards, Logout, Autologin
*   Rida        :   Publication (offres association) 
*   Abdelwadoud :   Page Profil (association et donneur)
*   Zakaria     :   ?

