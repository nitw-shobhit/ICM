//import Logo from './logo.jsx';
import React from 'react';
import ReactDOM from 'react-dom';

import styles from './icmMain.css';

class Header extends React.Component {

    render() {
        return <div className={styles.header-frame}>Header</div>;
    }
}

ReactDOM.render(
    <Header />,
	document.getElementById("root")
);