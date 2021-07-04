import React, { Component } from 'react'
import { DisplayCard } from './DisplayCard'

export default class AddCard extends Component {
   
  constructor(props) {
    super(props)
    this.state = {
      name: '',
      creditCardNumber: '',
        limit: '',
        cardDetail: []
    }
    this.setField = this.setField.bind(this)
    this.submitHandler = this.submitHandler.bind(this)
  }
  setField(field, e) {
    this.setState({
      [field]: e.target.value
    })
  }
 submitHandler(e) {
       
        e.preventDefault()
     let cardData = '';

      fetch('http://localhost:8090/card-service/add', {
          method: 'POST',
          headers: {
              'Content-Type': 'application/json',
              'Access-Control-Allow-Origin': '*'
          },
          body: JSON.stringify({ name: this.state.name, creditCardNumber: this.state.creditCardNumber, limit: this.state.limit })
      }).then(function (response) {
          if (response.ok) { 
              
          } else {
              return Promise.reject(response);
          }
      }).then(function () {
          return fetch(`http://localhost:8090/card-service/getcardlist`);
      }).then(function(response) {
          if (response.ok) {
              return response.json();
          } else {
              return Promise.reject(response);
          }
          }).then(jsonStr => {
              this.setState({ cardDetail: [jsonStr] });
              console.log('response recieved');
              console.log(this.state.cardDetail);
             
      }).catch(function (error) {
          console.warn(error);
         });

     console.log('card details');
     
     console.log('test card details');
  }
    render() {
        const { name, creditCardNumber, limit, cardDetail} = this.state
        return (
            <div style={{ paddingTop: 25, paddingLeft: 15 }}>
                <h2>Credit Card System</h2>
                  <h4> Add </h4>
                <form onSubmit={this.submitHandler} >
                    <label>Name</label><br />
                    <input
                        className='form-control css-input'
                        type='text'
                        aria-label='your name'
                        aria-required="true"
                        value={name}
                        onChange={this.setField.bind(null, 'name')} /><br />
                    <label>Card Number</label><br />
                    <input
                        className='form-control css-input'
                        type='text'
                        aria-label='your credit card number'
                        aria-required="true"
                        value={creditCardNumber}
                        onChange={this.setField.bind(null, 'creditCardNumber')} /><br />

                    <label>Limit</label><br />
                    <input
                        className='form-control css-input'
                        type='text'
                        aria-label='credit limit'
                        aria-required="true"
                        value={limit}
                        onChange={this.setField.bind(null, 'limit')} /><br /><br />
                    <input className='addButton' type='submit' value='Add' />
                    <div className='error'>{this.state.error}</div>
                </form>
                <div>
                   
                        <DisplayCard cardDetail={cardDetail} />
                   
                </div>
                
            </div>      
    );
  }
}