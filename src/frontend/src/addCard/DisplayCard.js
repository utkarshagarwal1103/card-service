import { React } from 'react'


export const DisplayCard = ( cardDetail) => {

    
    function renderTableHeader() {
        const headercolumns = ['Name', 'Card Number', 'Balance', 'Limit']
        return headercolumns.map((columns, index) => {
            return <th key={index}>{columns}</th>
        });
    }

  
    function renderTableData(cardDetailmap) {
       
        return cardDetailmap.cardDetail.map((detail, index) => {
            return detail.map((cardindividual, ind) => {
              
                console.log(cardindividual);
                const { id, name, creditCardNumber, balance, limit } = cardindividual //destructuring
                return (
                    <tr key={id}>
                        <td>{name}</td>
                        <td>{creditCardNumber}</td>
                        <td>&#163;{balance}</td>
                        <td>{limit}</td>
                    </tr>)
            })
        })
    
    }
    
    return (

            <div style={{ paddingLeft: 15}}>
                <h3>Existing Cards</h3>
              
                <table id ="cardTable" >
                    <tbody>
                        <tr>{renderTableHeader()}
                    </tr>
                    {renderTableData(cardDetail)}
                    </tbody>
                </table>
            </div>
        );
    
}