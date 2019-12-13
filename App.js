import React, {Component} from 'react';
import {Text, View, StyleSheet, Image} from 'react-native';

export default class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      image: '',
    };
  }

  componentDidMount() {
    if (this.props.image !== '') {
      this.setState({image: this.props.image});
    }
  }

  render() {
    console.log('IMAGE', this.state.image);
    return (
      <View style={styles.container}>
        {this.state.image !== '' && (
          <Image source={{uri: this.state.image}} style={styles.image} />
        )}
        {this.state.image === '' && <Text>Try Sharing Image from Gallery</Text>}
      </View>
    );
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
  },
  image: {
    height: 300,
    width: 300,
  },
});
