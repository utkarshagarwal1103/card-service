import React, { Component } from 'react';
import './App.css';
import './combinedPage.css';
import AddCard from './addCard'
import { DisplayCard } from './addCard/DisplayCard';
class App extends Component {
  render() {
      return (
          <div className="container" style={{marginBottom: 100}}>
              <AddCard />
              </div>
    );
  }
}

export default App;
