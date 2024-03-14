// import react and ReactDOm libraries

import React  from "react";
import  ReactDom  from "react-dom/client";
import './index.css'
import App from "./App";
import 'bulma/css/bulma.min.css';
import {Provider} from './context/users'

//searchImages();
// get a reference to the div with id root
const el = document.getElementById('root');
// tell react to take control of that element
const root = ReactDom.createRoot(el);

//create a component

//show the component on the screen
root.render(<Provider><App /></Provider>);


