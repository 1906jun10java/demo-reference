import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-databinding',
  templateUrl: './databinding.component.html',
  styleUrls: ['./databinding.component.css']
})
export class DatabindingComponent implements OnInit {

  title = 'Data Binding';
  image = 'assets/images/databinding.png';
  documentation = 'https://angular.io/guide/architecture#data-binding';

  // For Interpolation
  interpolationNotation = '{{}}';
  interpolation = 'Welcome to the Interpolation.';

  // For Event Binding
  eventBindingNotation = '()';

  public counter = 0;

  public incrementCounter(): void {
    this.counter++;
  }

  // For Two-Way Data Binding
  twoWayBindingNotation = '[()]';

  public user = {
    email: '',
    password: ''
  };

  // For Property Binding
  propertyBindingNotation = '[]';

  public objectStyle = {
    color: 'red',
    border: '1px solid black',
    cursor: 'pointer',
    margin: '2px'
  };

  public changeStyles(): void {
    if (this.objectStyle.color === 'red') {
      this.objectStyle.color = 'blue';
      this.objectStyle.border = '4px groove purple';
    } else if (this.objectStyle.color === 'blue') {
      this.objectStyle.color = 'green';
      this.objectStyle.border = '4px ridge yellow';
    } else {
      this.objectStyle.color = 'red';
      this.objectStyle.border = '4px solid black';
    }
  }

  ngOnInit() {

  }

}
